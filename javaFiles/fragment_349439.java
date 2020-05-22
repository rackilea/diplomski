function update() {
        // we get all the data in one go, if we only got partial
        // data, we could merge it with what we already got
        data = <% "{\"label\": \"Europe (EU28)\",\"data\": [[1, 20], [20, 10], [40, 3.9], [100, 40]]}";%>;   
        $.plot($("#myplace"), data, options);
}