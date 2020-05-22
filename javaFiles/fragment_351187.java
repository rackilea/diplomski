data='{"5": ">10%", "4": "<5%", "3": ">28 months", "2": "20%", "1": 100}'
newdata=$(echo $data |\
perl -pe 's/{/{\n/; s/}/\n}/; s/, /,\n/g; ' |\
perl -0pe 's/"/\\"/g; s/\n/\\n" + \n/g; s/^/"/gm; s/^"/\t\t"/gm; s/^\t\t"/"/; s/\}\\n.*$/}"/')

/bin/echo "String data = $newdata" >> /tmp/file.txt