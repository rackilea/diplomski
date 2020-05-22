ImagesService imagesService = ImagesServiceFactory.getImagesService();
Image oldImage = ImagesServiceFactory.makeImage(oldImageData);

// this throws an exception if data is not image or unsupported format
// you can wrap this in try..catch and act accordingly 
oldImage.getFormat();

// this is a dummy transform that does nothing
Transform transform = ImagesServiceFactory.makeCrop(0.0, 0.0, 1.0, 1.0);

// setting the output to JPEG
OutputSettings outputSettings = new OutputSettings(ImagesService.OutputEncoding.JPEG);
outputSettings.setQuality(100);

// apply dummy transform and output settings
Image newImage = imagesService.applyTransform(transform, oldImage, outputSettings);

byte[] newImageData = newImage.getImageData();