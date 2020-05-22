1.first download the file  wget http://python.org/ftp/python/3.3.0/Python-3.3.0.tgz or higher version as root user.
 2. change the directory to installed python
 3. example /opt/python3.3/;
 4. configure the files ./configure --prefix=/opt/python3.3
 5.make
 6. sudo make install
 7. /opt/python3.3/bin/python3
 8.opt/python3.3/bin/pyvenv ~/py33
 9.source ~/py33/bin/activate
 10. wget http://python-distribute.org/distribute_setup.py
 11.python distribute_setup.py  
 12. easy_install pip
 13. pip install bottle
 14. pip install warcat 
 15. if successfully installed warcat then check whether your warcat is installed or not.
 16. python3 -m warcat --help after enter then we can see some help commands like, list,concat,extract etc..
 17.python3 -m warcat list example/at.warc.gz
 this is worked for me ..enjoy