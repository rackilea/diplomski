if (al.get(i).contains("FrameNumber:")) {
    temp = al.get(i).replace("FrameNumber: ", "");
    temp = temp.trim();                    
    Frame retrievedFrame = new Frame();
    retrievedFrame.setFrameNumber(Integer.parseInt(temp));
    frameList.add(retrievedFrame);
    System.out.println("Frame Detected");
}