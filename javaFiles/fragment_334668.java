window.recordedLogs = [];

console.log = function (message) {

    if (typeof message === 'object') {
        message = JSON.stringify(message);
    }

    window.recordedLogs.push(message);
};