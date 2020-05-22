import { Injectable } from '@angular/core';

import {Http, Headers, Response} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class UploadService {

    //Import your APIs endpoint
    private url = AppSettings.API_ENDPOINT;

    constructor(private http:Http) { }

    upload(files:FileList){

        var formData = new FormData();


        if(files.length > 0){

            for(var i = 0; i < files.length; i++){
                formData.append("uploadfile", files[i]);
            }
            return this.http
                .post(this.url + '/api/upload', formData)
        }

    }
}