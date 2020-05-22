public class Cmd {
        private String success;
        private String cmd;
        List<Cmd> videos;
        private String video;
        private String numberofvideos;
        private String videoname;
        private String videourl;

        public String getCmd() {
            return cmd;
        }

        public void setCmd(String cmd) {
            this.cmd = cmd;
        }
        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public String getNumberOfVideos() {
            return numberofvideos;
        }
        public void setNumberOfVideos(String numberofvideos) {
            this.numberofvideos = numberofvideos;
        }
        public List<Cmd> getVideos() {
            return videos;
        }
        public void setVideos(List<Cmd> videos) {
            this.videos = videos;
        }
        public String getVideo() {
            return video;
        }
        public void setVideo(String video) {
            this.video = video;
        }

        public String getVideoName() {
            return videoname;
        }

        public void setVideoName(String videoname) {
            this.videoname = videoname;
        }
        public String getVideoURL() {
            return videourl;
        }

        public void setVideoURL(String videourl) {
            this.videourl = videourl;
        }

    }