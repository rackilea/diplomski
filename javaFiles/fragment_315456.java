@Override
public void updateAvatar(final MultipartFile multipartFile, final String speakerId) {

  final GridFS avatarGfs = new GridFS(getTemplate().getDb(), SPEAKER_AVATAR_COLLECTION);

  // Remove all sizes
  avatarGfs.remove(new BasicDBObject(SPEAKER_ID_FIELD, speakerId));
  System.out.println("hello from updateAvatar");

  for (SpeakerAvatarSize size : SpeakerAvatarSize.values()) {
    try {
      System.out.println("calling saveAvatar");
      saveAvatar(multipartFile, speakerId, size, avatarGfs);
    } catch (IOException e) {

      LOG.error("SpeakerRepository#updateAvatar", e);
    }
  }
}