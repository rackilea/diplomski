local_size=$(ls -l fileA | awk '{print $5}')
/usr/bin/ftp -n  <<EOF > ftp.log
open remote_nodename
user username password
cd /directory/to/files
dir fileA
bye
END
remote_size=$(grep 'fileA' ftp.log | awk '{print $5}')
[ $remote_size -eq $local_size ] && echo 'OK' || echo 'NOTOK'