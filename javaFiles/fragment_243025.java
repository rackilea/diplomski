import { HttpClient, HttpParams } from '@angular/common/http';

getMnosList() {
        var simboxid = this.getItem.id;
 let params = new HttpParams().set('simboxid', simboxid);
        return this.http.get(`${environment.apiUrl}/MNO`, { params: params } )
 .pipe(map(this.extractData)),
                       this.catchError);

private extractData(res: any): any {
        return res.data || []; // or do what needs to be done
    }

private catchError = (observable: Observable<any>): Observable<never> => {
        return <Observable<never>>observable.pipe(catchError((error: any) => {
            return observableThrowError(error || 'Server error');
        }));
    }