cd ~/projects/so-test/java-crlf-token/JavaAppCRLF  
$ cat test.sh
#!/bin/bash - 
# SET /P input1=1st Input: 
echo -n "1st Input:"; 
read input1;
#SET /P input2=2nd Input: 
echo -n "2nd Input:"; 
read input2;
#ECHO 1st Input: %input1% and 2nd Input: %input2%
echo -n "1st Input: ${input1} and 2nd Input: ${input2}"