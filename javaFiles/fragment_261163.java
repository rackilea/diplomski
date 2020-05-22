import PIL
from PIL import Image
from PIL.TiffTags import TAGS

im = Image.open("03512378.tif")
print("PIL reports '"+ str(im.n_frames) +"' frames")

count = 1
img_numbers = []
while True:
    try:
        im.seek(im.tell()+1)
        meta = {TAGS[key] : im.tag[key] for key in im.tag.keys()}
        img_numbers.append((meta["ImageDescription"][0]))
        # Note: elements in the meta dict are tuples
    except EOFError:
        break
    count += 1

s = set(img_numbers) # remove duplicates
print("Number of unique frames : " + str(len(s)))
print("Number of counted frames: " + str(count))