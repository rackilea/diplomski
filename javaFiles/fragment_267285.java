%function [ ii_image ] = RGB2IlluminationInvariant( image, alpha )

%Initialize input (for executing the example):
image = imread('peppers.png');
image = max(image, 1); %Replace zero values with 1, because log(0) is -Inf
image = double(image)/255; %Convert image to double in range [1/255, 1]. In JAVA, you should use double(pix)/255 if pix is a byte in range [0, 255].
alpha = 0.9;

ii_image = 0.5 + log(image(:,:,2)) - alpha*log(image(:,:,3)) - (1-alpha)*log(image(:,:,1));

%Assume elements in JAVA are stored in three 2D arrays (3 planes): R, G, B
%For example: double[][] R = new double[384][512];
%In Matlab 3 planes are:
R = image(:,:,1);
G = image(:,:,2);
B = image(:,:,3);
%II_image = 0.5 + log(G) - alpha*log(B) - (1-alpha)*log(R);
II_image = zeros(size(R));

%Equivalent for loop (simple to implement in JAVA):
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
image_width = size(image, 2);
image_height = size(image, 1);
for y = 1:image_height %Iterate rows, In JAVA: for(y = 0; y < image_height; y++)
    for x = 1:image_width %Iterate columns, In JAVA: for(x = 0; x < image_width; x++)
        r = R(y, x); %In JAVA: double r = R[y][x];
        g = G(y, x);
        b = B(y, x);

        p = 0.5 + log(g) - alpha*log(b) - (1.0-alpha)*log(r);

        II_image(y, x) = p;
    end
end

%Display ii_image
figure;imshow(ii_image, []);impixelinfo;title('ii\_image');

%Show difference (for debugging):
%figure;imshow(ii_image - II_image, []);impixelinfo

%Display minimum and maximum - values are not valid as pixel values in JAVA.
disp(['min(ii_image) = ', num2str(min(ii_image(:)))]);
disp(['max(ii_image) = ', num2str(max(ii_image(:)))]);


%Convert II_image range to [0, 1]
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Find minimum and maximum (in JAVA you can do it inside the loop).
lo = min(II_image(:));
hi = max(II_image(:));

%Apply linear transformation:
II_image = (II_image - lo) / (hi - lo);

figure;imshow(II_image, []);impixelinfo;title('II\_image');
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%