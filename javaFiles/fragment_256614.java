#!/bin/bash
#Author: Yucca Nel http://thejarbar.org
#Will restart system
#Modify these variables as needed...
tempWork=/tmp/work
defaultStartScript=/etc/init.d/rc.local
locBin=/usr/local/bin
javaUsrLib=/usr/lib/jvm
defaultMaven=3.0.4
defaultNetBeansVer=7.1
mavenUsrLib=/usr/lib/maven
defaultIDEA=11.0.1

sudo mkdir -p $javaUsrLib
mkdir -p $tempWork
sudo mkdir -p $mavenUsrLib
mkdir -p $HOME/.m2
mkdir -p $HOME/SVN

cd $tempWork

#Update this line to reflect newer versions of JDK...
wget http://download.oracle.com/otn-pub/java/jdk/7u2-b13/jdk-7u2-linux-i586.tar.gz

#Extract the download
tar -zxvf $tempWork/*
rm -rf $tempWork/*.gz

#Move it to where it can be found...
sudo mv -f $tempWork/* $javaUsrLib/
export JAVA_HOME="$javaUsrLib/jdk1.7.0_02"

sudo ln -f -s $javaUsrLib/jdk1*/bin/* /usr/bin/
rm -rf $tempWork/*
#Update this line to reflect newer versions of JDK...

if ! grep "JAVA_HOME=$javaUsrLib/jdk1.7.0_02" /etc/environment
then
echo "JAVA_HOME=$javaUsrLib/jdk1.7.0_02" | sudo tee -a /etc/environment
fi

source /etc/environment

read -p "Please [Enter] full path name of your local startup script ($defaultStartScript is the default). Please
make sure on this before providing a value by consulting documentation for your system:" locStartScript
locStartScript=${locStartScript:-$defaultStartScript}

read -p "Please [Enter] Maven Version ($defaultMaven is default):" mavenVersion
mavenVersion=${mavenVersion:-$defaultMaven}

read -p "Please [Enter] NetBeans Version ($defaultNetBeansVer is default):" netbeansVersion
netbeansVersion=${netbeansVersion:-$defaultNetBeansVer}

read -p "Please [Enter] IDEA Version ($defaultIDEA is default):" ideaVersion
ideaVersion=${ideaVersion:-$defaultIDEA}


if [ ! -f $locStartScript ]
then
echo "The file you provided could not be found. Remember to include the full path and try again. Exiting in 7 secs..."
sleep 7
exit 1
fi

wget http://mirrors.powertech.no/www.apache.org/dist//maven/binaries/apache-maven-$mavenVersion-bin.tar.gz
tar -zxvf $tempWork/*

#Move it to a more logical location
sudo mv -f $tempWork/apache-maven-$mavenVersion $mavenUsrLib/
sudo ln -f -s $mavenUsrLib/apache-maven-$mavenVersion/bin/* /usr/bin/

#If you have Maven on Windows and use VirtualBox, you can set up the maven to be a virtualbox shared folder.
#The name must match the name used below (ignore if irrelevant to you).


if [ -f /sbin/mount.vboxsf ]
then
sudo /sbin/umount $HOME/.m2
sudo /sbin/umount $mavenUsrLib
sudo /sbin/mount.vboxsf .m2 $HOME/.m2
sudo /sbin/mount.vboxsf maven $mavenUsrLib
fi

if mountpoint -q $HOME/.m2 &&  mountpoint -q $mavenUsrLib
then
tar -zxvf $tempWork/*
sudo mv -f $tempWork/apache-maven-$mavenVersion $mavenUsrLib/
#Add it to the start script to automate process...
if ! grep "sudo /sbin/mount.vboxsf .m2 $HOME/.m2" $locStartScript
then
echo "sudo /sbin/mount.vboxsf .m2 $HOME/.m2" | sudo tee -a $locStartScript
fi

if ! grep "sudo /sbin/mount.vboxsf maven $mavenUsrLib" $locStartScript
then
echo "sudo /sbin/mount.vboxsf maven $mavenUsrLib" | sudo tee -a $locStartScript
fi
sudo chmod +x $locStartScript

#Create a mount and unmount script file...
rm -rf $tempWork/*
echo '#!/bin/bash' > $tempWork/maven-mount.sh
echo "sudo /sbin/mount.vboxsf .m2 $HOME/.m2" >> $tempWork/maven-mount.sh
echo "sudo /sbin/mount.vboxsf maven $mavenUsrLib" >> $tempWork/maven-mount.sh
echo "echo 'mounted maven'" >> $tempWork/maven-mount.sh
echo "exit 0" >> $tempWork/maven-mount.sh

echo '#!/bin/bash' > $tempWork/maven-umount.sh
echo "sudo umount $HOME/.m2" >> $tempWork/netbeans-umount.sh
echo "sudo umount $mavenUsrLib" >> $tempWork/netbeans-umount.sh
echo "echo 'unmounted maven'" >> $tempWork/maven-mount.sh
echo 'exit 0' >> $tempWork/maven-umount.sh

#Script for mounting ALL VirtualBox shared solders....
#If there isn't one create one...
if [ ! -f $locBin/mount-all-from-host.sh ]
then
echo '#!/bin/bash' > /mount-all-from-host.sh
echo "sudo /sbin/mount.vboxsf .m2 $HOME/.m2" | sudo tee -a $tempWork/mount-all-from-host.sh
echo "sudo /sbin/mount.vboxsf maven $mavenUsrLib" | sudo tee -a $tempWork/mount-all-from-host.sh
echo "exit 0" | sudo tee -a $tempWork/mount-all-from-host.sh

#Otherwise if there is one, but no mount, add one...
elif ! grep "sudo /sbin/mount.vboxsf .m2 $HOME/.m2" $locBin/mount-all-from-host.sh
then
sudo sed -ie '$d' $locBin/mount-all-from-host.sh
echo "sudo /sbin/mount.vboxsf .m2 $HOME/.m2" | sudo tee -a $locBin/mount-all-from-host.sh
echo "exit 0" | sudo tee -a $locBin/mount-all-from-host.sh

elif ! grep "sudo /sbin/mount.vboxsf maven $mavenUsrLib" $locBin/mount-all-from-host.sh
then
sudo sed -ie '$d' $locBin/mount-all-from-host.sh
echo "sudo /sbin/mount.vboxsf maven $mavenUsrLib" | sudo tee -a $locBin/mount-all-from-host.sh
echo "exit 0" | sudo tee -a $locBin/mount-all-from-host.sh

fi

#Script for unmounting ALL VirtualBox shared folders...
#If there isn't one create one...
if [ ! -f $locBin/umount-all-from-host.sh ]
then
echo '#!/bin/bash' > $tempWork/umount-all-from-host.sh
echo "sudo umount -a -t vboxsf" | sudo tee -a $tempWork/umount-all-from-host.sh
echo "echo 'unmounted all VirtualBox shared folders'" | sudo tee -a $tempWork/umount-all-from-host.sh
echo "exit 0" | sudo tee -a $tempWork/umount-all-from-host.sh
fi

chmod +x $tempWork/*
sudo mv -f $tempWork/* $locBin/
rm -rf $tempWork/*
fi

sudo ln -f -s $mavenUsrLib/apache-maven-$mavenVersion/bin/* /usr/bin/
rm -rf $tempWork/*


wget http://dlc.sun.com.edgesuite.net/netbeans/$netbeansVersion/final/bundles/netbeans-$netbeansVersion-ml-javase-linux.sh
sh $tempWork/*sh;


#Add Netbeans launcher to your PATH. Doing so allows you to run 'netbeans' command from the terminal
#This line will need to be changed if you changed the default install location (IOW Netbeans is not in ~/)
sudo ln -f -s ~/netbeans-7.1/bin/netbeans /usr/bin/;

#If you use VirtualBox , you can share your projects between Host and guest. Name of shared
#folder must match 'NetBeansProjects'
mkdir -p $HOME/NetBeansProjects

if [ -f /sbin/mount.vboxsf ]
then
sudo /sbin/umount $HOME/NetBeansProjects
sudo /sbin/mount.vboxsf NetBeansProjects $HOME/NetBeansProjects
fi

if mountpoint -q $HOME/NetBeansProjects
then
#Add it to the start script to automate process...
if ! grep "sudo /sbin/mount.vboxsf NetBeansProjects $HOME/NetBeansProjects" $locStartScript
then
echo "sudo /sbin/mount.vboxsf NetBeansProjects $HOME/NetBeansProjects" | sudo tee -a $locStartScript
fi
chmod +x $locStartScript

#Create a mount and unmount script file...
rm -rf $tempWork/*
echo '#!/bin/bash' > $tempWork/netbeans-mount.sh
echo "sudo /sbin/mount.vboxsf NetBeansProjects $HOME/NetBeansProjects" >> $tempWork/netbeans-mount.sh
echo "mounted NetBeansProjects" >> $tempWork/netbeans-mount.sh
echo "exit 0" >> $tempWork/netbeans-mount.sh

echo '#!/bin/bash' > /netbeans-umount.sh
echo "sudo umount $HOME/NetBeansProjects" >> $tempWork/netbeans-umount.sh
echo "unmounted NetBeansProjects" >> $tempWork/netbeans-mount.sh
echo 'exit 0' >> $tempWork/netbeans-umount.sh

#Script for mounting ALL VirtualBox shared solders....
#If there isn't one create one...
if [ ! -f $locBin/mount-all-from-host.sh ]
then
echo '#!/bin/bash' > $tempWork/mount-all-from-host.sh
echo "sudo /sbin/mount.vboxsf NetBeansProjects $HOME/NetBeansProjects" | sudo tee -a $tempWork/mount-all-from-host.sh
echo "exit 0" | sudo tee -a $tempWork/mount-all-from-host.sh

#Otherwise if there is one, but no mount, add one...
elif ! grep "sudo /sbin/mount.vboxsf NetBeansProjects" $locBin/mount-all-from-host.sh
then
sudo sed -ie '$d' $locBin/mount-all-from-host.sh
echo "sudo /sbin/mount.vboxsf NetBeansProjects $HOME/NetBeansProjects" | sudo tee -a $locBin/mount-all-from-host.sh
echo "exit 0" | sudo tee -a $locBin/mount-all-from-host.sh
fi

#Script for unmounting ALL VirtualBox shared folders...
#If there isn't one create one...
if [ ! -f $locBin/umount-all-from-host.sh ]
then
echo '#!/bin/bash' > $tempWork/umount-all-from-host.sh
echo "sudo umount -a -t vboxsf" | sudo tee -a $tempWork/umount-all-from-host.sh
echo "echo 'unmounted all VirtualBox shared folders'" | sudo tee -a $tempWork/umount-all-from-host.sh
echo "exit 0" | sudo tee -a $tempWork/umount-all-from-host.sh
fi

chmod +x $tempWork/*
sudo mv -f $tempWork/* $locBin/
rm -rf$tempWork/*
fi

wget http://download-ln.jetbrains.com/idea/ideaIC-$ideaVersion.tar.gz;
tar -zxvf $tempWork/*;

#Move it to a better location...
mv -f $tempWork/idea-IC-* $HOME/;
rm -rf $tempWork/*

sudo ln -f -s $HOME/idea-*/bin/* /usr/bin/;

#If you use VirtualBox , you can share your projects between Host and guest. Name of shared
#folder must match 'IdeaProjects'
mkdir -p $HOME/IdeaProjects

if [ -f /sbin/mount.vboxsf ]
then
sudo /sbin/umount $HOME/IdeaProjects
sudo /sbin/mount.vboxsf IdeaProjects $HOME/IdeaProjects
fi

if mountpoint -q $HOME/IdeaProjects
then
#Add it to the start script to automate process...
if ! grep "sudo /sbin/mount.vboxsf IdeaProjects $HOME/IdeaProjects" $locStartScript
then
echo "sudo /sbin/mount.vboxsf IdeaProjects $HOME/IdeaProjects" | sudo tee -a $locStartScript
fi
chmod +x $locStartScript

#Create a mount and unmount script file...
rm -rf $tempWork/*
echo '#!/bin/bash' > $tempWork/idea-mount.sh
echo "sudo /sbin/mount.vboxsf IdeaProjects $HOME/IdeaProjects" >> /idea-mount.sh
echo "echo 'mounted IdeaProjects'" >> $tempWork/idea-mount.sh
echo "exit 0" >> $tempWork/idea-mount.sh

echo '#!/bin/bash' > $tempWork/idea-umount.sh
echo "sudo umount $HOME/IdeaProjects" >> $tempWork/idea-umount.sh
echo "echo 'unmounted IdeaProjects'" >> $tempWork/idea-mount.sh
echo 'exit 0' >> $tempWork/idea-umount.sh

#Script for mounting ALL VirtualBox shared solders....
#If there isn't one create one...
if [ ! -f $locBin/mount-all-from-host.sh ]
then
echo '#!/bin/bash' > $tempWork/mount-all-from-host.sh
echo "sudo /sbin/mount.vboxsf IdeaProjects $HOME/IdeaProjects" | sudo tee -a $tempWork/mount-all-from-host.sh
echo "exit 0" | sudo tee -a $tempWork/mount-all-from-host.sh

#Otherwise if there is one, but no mount, add one...
elif ! grep "sudo /sbin/mount.vboxsf IdeaProjects" $locBin/mount-all-from-host.sh
then
sudo sed -ie '$d' $locBin/mount-all-from-host.sh
echo "sudo /sbin/mount.vboxsf IdeaProjects $HOME/IdeaProjects" | sudo tee -a $locBin/mount-all-from-host.sh
echo "exit 0" | sudo tee -a $locBin/mount-all-from-host.sh
fi

#Script for unmounting ALL VirtualBox shared folders...
#If there isn't one create one...
if [ ! -f $locBin/umount-all-from-host.sh ]
then
echo '#!/bin/bash' > $tempWork/umount-all-from-host.sh
echo "sudo umount -a -t vboxsf" | sudo tee -a $tempWork/umount-all-from-host.sh
echo "echo 'unmounted all VirtualBox shared folders'" | sudo tee -a $tempWork/umount-all-from-host.sh
echo "exit 0" | sudo tee -a $tempWork/umount-all-from-host.sh
fi

chmod +x $tempWork/*
sudo mv -f $tempWork/* $locBin/
rm -rf $tempWork/*
fi

if [ -f /sbin/mount.vboxsf ]
then
sudo /sbin/umount $HOME/SVN
sudo /sbin/mount.vboxsf SVN $HOME/SVN
fi

if mountpoint -q $HOME/SVN
then
#Add it to the start script to automate process...
if ! grep "sudo /sbin/mount.vboxsf SVN $HOME/SVN" $locStartScript
then
echo "sudo /sbin/mount.vboxsf SVN $HOME/SVN" | sudo tee -a $locStartScript
fi
chmod +x $locStartScript

#Create a mount and unmount script file...
rm -rf $tempWork/*
echo '#!/bin/bash' > $tempWork/svn-mount.sh
echo "sudo /sbin/mount.vboxsf SVN $HOME/SVN" >> /svn-mount.sh
echo "echo 'mounted SVN'" >> $tempWork/svn-mount.sh
echo "exit 0" >> $tempWork/svn-mount.sh

echo '#!/bin/bash' > $tempWork/svn-umount.sh
echo "sudo umount $HOME/SVN" >> $tempWork/svn-umount.sh
echo "echo 'unmounted SVN'" >> $tempWork/svn-mount.sh
echo 'exit 0' >> $tempWork/svn-umount.sh

#Script for mounting ALL VirtualBox shared solders....
#If there isn't one create one...
if [ ! -f $locBin/mount-all-from-host.sh ]
then
echo '#!/bin/bash' > $tempWork/mount-all-from-host.sh
echo "sudo /sbin/mount.vboxsf SVN $HOME/SVN" | sudo tee -a $tempWork/mount-all-from-host.sh
echo "exit 0" | sudo tee -a $tempWork/mount-all-from-host.sh

#Otherwise if there is one, but no mount, add one...
elif ! grep "sudo /sbin/mount.vboxsf SVN" $locBin/mount-all-from-host.sh
then
sudo sed -ie '$d' $locBin/mount-all-from-host.sh
echo "sudo /sbin/mount.vboxsf SVN $HOME/SVN" | sudo tee -a $locBin/mount-all-from-host.sh
echo "exit 0" | sudo tee -a $locBin/mount-all-from-host.sh
fi

#Script for unmounting ALL VirtualBox shared folders...
#If there isn't one create one...
if [ ! -f $locBin/umount-all-from-host.sh ]
then
echo '#!/bin/bash' > $tempWork/umount-all-from-host.sh
echo "sudo umount -a -t vboxsf" | sudo tee -a $tempWork/umount-all-from-host.sh
echo "echo 'unmounted all VirtualBox shared folders'" | sudo tee -a $tempWork/umount-all-from-host.sh
echo "exit 0" | sudo tee -a $tempWork/umount-all-from-host.sh
fi

chmod +x $tempWork/*
sudo mv -f $tempWork/* $locBin/
rm -rf $tempWork/*
fi

sudo rm -rf $tempWork
sudo /sbin/reboot

exit 0