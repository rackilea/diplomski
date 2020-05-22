% read the second image
img2 = imread('http://i.stack.imgur.com/zyHuj.jpg');
img2 = im2double(rgb2gray(img2));

% detect coca-cola logos
bw = im2bw(img2);                                       % Otsu's thresholding
bw = imfill(~bw, 'holes');                              % fill holes
stats = regionprops(bw, {'Centroid', 'BoundingBox'});   % connected components

% show centers and bounding boxes of each connected component
centers = vertcat(stats.Centroid);
imshow(img2), hold on
plot(centers(:,1), centers(:,2), 'LineStyle','none', ...
    'Marker','x', 'MarkerSize',20, 'Color','r', 'LineWidth',3)
for i=1:numel(stats)
    rectangle('Position',stats(i).BoundingBox, ...
        'EdgeColor','g', 'LineWidth',3)
end
hold off