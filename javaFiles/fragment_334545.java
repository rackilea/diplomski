clear
close all

%% Define computer-specific variables

ipSender = '127.0.0.1'; % LocalHost for testing on the same computer
portSender = 9090;

ipReceiver = '127.0.0.1'; % LocalHost for testing on the same computer
portReceiver = 9091;

%% Create UDP Object

udpReceiver = udp(ipSender, portSender, 'LocalPort', portReceiver);
udpReceiver.InputBufferSize = 102400; % 100KB to be safe
udpReceiver.InputDatagramPacketSize = 65535; % Max possible

%% Connect to UDP Object

fopen(udpReceiver);
[A, count] = fread(udpReceiver, 102400, 'uint8'); % Receiving in proper format, big size just to be safe
A = uint8(A); % Just making sure it worked correctly

fileID = fopen('du.jpg','w'); % Save as a JPEG file because it was received this way
fwrite(fileID, A);
I = imread('du.jpg'); % Test if it saved correctly
imshow(I); 

%% Close

fclose(udpReceiver);
delete(udpReceiver);