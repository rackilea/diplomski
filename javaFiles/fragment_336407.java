import {Component, OnInit} from '@angular/core';

declare let EventSource:any;

@Component({
    selector: 'notification-cmp',
    templateUrl: 'notification.component.html'  
})

export class NotificationComponent implements OnInit {
   connect(): void {
        let source = new EventSource('http://localhost:8080/stream');
        source.addEventListener('message', message => {
            let n: Notification; //need to have this Notification model class in angular2
            n = JSON.parse(message.data);
            console.log(message.data); 
        });
    }
}