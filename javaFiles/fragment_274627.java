public void onCallMediaState(OnCallMediaStateParam param) {
    CallInfo ci = this.getInfo();

    for(int i = 0; i < ci.getMedia().size(); i++) {
        if(ci.getMedia().get(i).getType() == pjmedia_type.PJMEDIA_TYPE_AUDIO) {

            AudioMedia aum = AudioMedia.typecastFromMedia(this.getMedia(i));
        }
    }
}