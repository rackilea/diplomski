func deleteCity(w http.ResponseWriter, r *http.Request) {
    log.Println("deleteCity handler called")
    dump, err := httputil.DumpRequest(r, true)
    if err != nil {
        http.Error(w, fmt.Sprint(err), http.StatusInternalServerError)
        return
    }
    log.Printf("%q\n", dump)
    var city string = r.FormValue("city")
    log.Printf("city: %q\n", city)
}