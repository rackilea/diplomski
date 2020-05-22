(.*?) // anything 
([0-9]{4}) // followed by 4 digits
([^0-9]*?) // followed by anything excepted digits
([a-z]+) // followed by a sequence of text in lowercase
(.*?) // followed by anything
([0-9]{2}) // until it finds 2 digits
(.*?) // followed by anything
([0-9]{2}) // until it finds 2 digits again
(.*?) // followed by anything
([0-9]{4}) // until if finds 4 consecutive digits
_([^.]+) // an underscore followed by anything except a dot '.'
[.]zip // the file extension