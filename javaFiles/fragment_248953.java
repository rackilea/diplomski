%!PS-Adobe-3.0

% builds string to hold all image data at once:
/imgdata 8 8 3 mul mul string def

% set context to scale image to 256 X 256 pt (from 1 x1 pt)

256 256 scale

% Dimensions of image (width * height * bpp)

8 8 8

% Image transformation Matrix - [width 0 0 -height 0 height]: flips 
% vertical axis so we have top to bottom data:
[8 0 0 -8 0 8] 

% Procedure to read the image data and return it as a string:
{ currentfile % read inline data
  imgdata  % put read data into this variable
  readhexstring % performs the reading
  pop % discards read operation status
}

%indicates single data source:
false

%number of colors per pixel:
3
% Image operator: consumes previous parameters and renders the image
% followed by Image hexadecimal data in ASCII
colorimage 
0000000000200000400000600000800000a00000c00000e0200000200020
2000402000602000802000a02000c02000e0400000400020400040400060
4000804000a04000c04000e06000006000206000406000606000806000a0
6000c06000e08000008000208000408000608000808000a08000c08000e0
a00000a00020a00040a00060a00080a000a0a000c0a000e0c00000c00020
c00040c00060c00080c000a0c000c0c000e0e00000e00020e00040e00060
e00080e000a0e000c0e000e0

showpage