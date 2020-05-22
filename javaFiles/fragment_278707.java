function consult(number, sequence){
    //Here you call your loading
    $.blockUI({ message: '<h1><img src="loading.gif" /> Wainting...</h1>' });

    form = document.forms[1];

    form.number.value = number;
    form.sequence.value = sequence;

    form.submit();

}