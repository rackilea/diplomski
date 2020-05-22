tar xzvf opencv-2.4.6.1.tar.gz

cd opencv-2.4.6.1

mkdir build; cd build

cmake -D CMAKE_BUILD_TYPE=RELEASE -D CMAKE_INSTALL_PREFIX=/usr/local -D WITH_TBB=ON ..

make

sudo make install