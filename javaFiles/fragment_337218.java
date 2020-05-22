byte[] lblobPic;
lblobPic = r.get(ALUNO.PFOTO);
if (lblobPic != null) {
    String argStr = Arrays.toString(lblobPic);
    peopleDto.setUrlPic(argStr);
}