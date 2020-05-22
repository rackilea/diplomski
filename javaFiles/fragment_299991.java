function storageChange (event) {

if(event.key === 'logged_in') {
    alert('Logged in: ' + event.newValue)
}
}
window.addEventListener('storage', storageChange, false);