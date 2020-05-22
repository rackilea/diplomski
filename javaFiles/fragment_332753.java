public static byte[] reconstruct(byte[] arr){
    byte[] result = new byte[arr.length];
    System.arraycopy(arr, 0, result, 0, 16); //copy metadata1 
    System.arraycopy(arr, 33, result, 16, arr.length-33); //copy remaining 
    System.arraycopy(arr, 16, result, 16 + arr.length-33, 33-16); //copy metadata2 
    return result;
}