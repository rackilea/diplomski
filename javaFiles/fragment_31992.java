#!/bin/bash
echo -n "Is this a good question (y/n)? "
read answer
if echo "$answer" | grep -iq "^y" ;then
    echo Yes
else
    echo No
fi