if (radiobutton_param value employee) {
    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
    setDetails(whatever);
    return getAuthenticationManager().authenticate(authRequest);
} else if (radiobutton_param value customer) {
    CustomerAuthenticationToken authRequest = new CustomerAuthenticationToken(username, password);
    setDetails(whatever);
    return getAuthenticationManager().authenticate(authRequest);
}