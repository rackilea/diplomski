import React from 'react';
import request from 'request';
import restful, { requestBackend } from 'restful.js';

const api = restful('http://someUrl/v1/mobile', requestBackend(request));
const totals = api.one('statusOrders',1); //organizationID = 1

class RestGps extends React.Component {

    state = { text: "loading ..." };

    componentDidMount = () => {
        totals.get().then((response) => {
            const requestBody = response.body();
            const totalsOrders = requestBody.data(); // assuming this is object
            this.setState({ text: JSON.stringify(totalsOrders) });
        })
    }

    render = () => {
        return(
           <div className="container">
                 <p>{this.state.text}</p>
                //Here I want to print the values.
            </div>
        )
    }
}

export default RestGps