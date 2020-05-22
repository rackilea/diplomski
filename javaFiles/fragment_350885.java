#! /bin/bash
echo "Test is Running...";
dir=$(pwd);
echo $dir;
cd ..
echo ${PWD}
dir2=$(pwd);
cd $dir;
$dir2/ant/bin/ant tests -buildfile $dir/build.xml -logfile $dir/Rebuild.log