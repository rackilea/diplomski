func captureOutput(_ captureOutput: AVCaptureOutput!, didOutputSampleBuffer sampleBuffer: CMSampleBuffer!, from connection: AVCaptureConnection!)
{


    var cameraImage: CIImage

    var image: UIImage ;
    let pixelBuffer = CMSampleBufferGetImageBuffer(sampleBuffer)
    cameraImage = CIImage(cvPixelBuffer: pixelBuffer!)
    let context:CIContext = CIContext.init(options: nil)
    let cgImage:CGImage = context.createCGImage(cameraImage, from: cameraImage.extent)!
    image = UIImage(cgImage: cgImage)
    DispatchQueue.main.async
        {



            self.imageView.image = image //live video captured from camera streamed to the device's own UIImageView


    }





    let thumbnail = resizeImage(image: image, targetSize: CGSize.init(width: 400, height: 400)) // snapshot image from camera resized 

    let data = UIImageJPEGRepresentation(thumbnail,0.000005) //the snapshot image converted into byte data
    let base64String = data!.base64EncodedString(options: Data.Base64EncodingOptions(rawValue: 0))  
    // byte image data is encoded to a base64String

    var encodeImg=base64String.addingPercentEncoding(withAllowedCharacters:  .urlQueryAllowed  )


    encodeImg = encodeImg! + String("%") // termination char % is added at the end
    var sendData = String("0%")
    if(live)
     {
    sendData = encodeImg!
     }
    client?.send(string: sendData!) //sent as a String using TCPClient socket



}