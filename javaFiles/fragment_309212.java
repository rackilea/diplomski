function updateYourTime() {
        var now = new Date(), 
            months = ['January', 'February', '...']; 
            time = now.getHours() + ':' + now.getMinutes(), 

            date = [now.getDate(), 
                    months[now.getMonth()],
                    now.getFullYear()].join(' ');

        document.getElementById('currentTime').innerHTML = [date, time].join(' / ');

        setTimeout(updateYourTime, 1000);//This method will call for every second
    }
    updateYourTime(); // initial call