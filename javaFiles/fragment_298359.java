addShopToPreferred(shopId: string): Observable<any> {
    const httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': this.tokenService.getToken()
        })
    };
    return this.httpClient.post(this.apiUrl + "/like?shop=" + shopId, null, httpOptions)
        .pipe(map(response => {
            return response;
        }));
}