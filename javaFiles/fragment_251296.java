String from = message.getFrom();
int participantId = Integer.valueOf(QBChatUtils.parseQBUser(from));


QBUsers.getUser(participantId, new QBCallbackImpl() {
@Override
public void onComplete(Result result) {
if (result.isSuccess()) {
QBUserResult qbUserResult = (QBUserResult) result;
Log.i(TAG, ">>> User: " + qbUserResult.getUser().getFullName()