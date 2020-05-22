import ActivityResult from 'react-native-activity-result';

_onLaunch = async () => {
    const activity = await ActivityResult.resolveActivity('com.causalidea.cikad.showkad.READ_MYKAD');
    if (!activity) {
        console.warn('Please install the othe app.');
        ToastAndroid.show(`MyKAD application reader is not install`, ToastAndroid.SHORT, ToastAndroid.BOTTOM);
    } else {
        console.log(`Activity will be handled by ${activity.package}`);
        ToastAndroid.show(`Activity will be handled by ${activity.package}`, ToastAndroid.SHORT, ToastAndroid.BOTTOM);
    }

    // Start an activity for a result
    let uniqueId = 0;
    let args = {READ_PHOTO: false};
    ToastAndroid.show(`Test`, ToastAndroid.SHORT, ToastAndroid.BOTTOM);
    const response = await ActivityResult.startActivityForResult(uniqueId, 'com.causalidea.cikad.showkad.READ_MYKAD', args);
    ToastAndroid.show(`Result code: ${response.resultCode}`, ToastAndroid.LONG, ToastAndroid.BOTTOM);


    if (response.resultCode !== ActivityResult.OK) {
        ToastAndroid.show(`Invalid result from activity.`, ToastAndroid.SHORT, ToastAndroid.BOTTOM);
        throw new Error('Invalid result from activity.');
    } else {
        console.log('Got the following response: ' + response.data);
        ToastAndroid.show(`Response:\n${JSON.stringify(response)}`, ToastAndroid.SHORT, ToastAndroid.BOTTOM);
    }

    // Finish an activity with a result. This will close the caller too.
    //ActivityResult.finish(ActivityResult.OK, 'com.causalidea.cikad.showkad.READ_MYKAD', args);
}