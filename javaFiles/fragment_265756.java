public logOut():Observable<string> {
    return this.client.get<string>("../Login");
}

public disconnect():void {
    this.service.logOut().subscribe(redirectUrl => {
        const baseUrl = window.location.href.split('/').slice(0,4).join('/');
        window.location.href = `${baseUrl}/${redirectUrl}`;
    }, fail => {
        // Do fail stuff
    });
}