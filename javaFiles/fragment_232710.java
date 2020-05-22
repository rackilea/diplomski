[WebGet(UriTemplate = "ResumeDownload/{clientID}/{fileName}/{startByte}")]
        public Stream resumeDownload(String clientID, String fileName, String startByte)
        {
            MemoryStream responseStream = new MemoryStream();
            Stream fileStream = File.Open(@jobRepPath + fileName.Replace("___", "."), FileMode.Open);

            fileStream.Seek(Convert.ToInt32(startByte), SeekOrigin.Begin);

            int length = (int)(fileStream.Length - Convert.ToInt32(startByte));
            byte[] buffer = new byte[length];
            fileStream.Read(buffer, 0, length);
            responseStream.Write(buffer, 0, length);

            fileStream.Close();
            responseStream.Position = 0;

            return responseStream; 
        }