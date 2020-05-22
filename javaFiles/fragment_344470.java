javaaddpath('javacv.jar');
import org.bytedeco.javacv.*;
import org.bytedeco.javacpp.*;
grabber = FrameGrabber.createDefault(0)
grabber.start();
img = grabber.grab();
buff = img.image(1);
w = img.imageWidth;
h = img.imageHeight;
%// from here is inefficient code
doubleBuff = buff.asDoubleBuffer;
n = doubleBuff.remaining;
data = zeros(n,1);
for i=1:n
    data(i) = doubleBuff.get();
end
I = typecast(data, 'uint8');
I = cat(3,                          ...
        reshape(I(3:3:end),[w h])', ...
        reshape(I(2:3:end),[w h])', ...
        reshape(I(1:3:end),[w h])'  ...
   );
imshow(I);