Function<T, List<NameMe>> serviceFunc = null; 
if (SendType.student.equals(sendType)) {
    serviceFunc = tStudentServiceImpl::queryByParam;
} else if (SendType.teacher.equals(sendType)) {
    serviceFunc = tTeacherServiceImpl::queryByParam;
} else {
    serviceFunc = tSchoolmasterServiceImpl::queryByParam;
}
getAndSendMessageItems(serviceFunc, conditionMap, availdSendMsgCount, sendType);