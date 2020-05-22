String a;
String b;
a = get_string_from_complex_procedure_1();
b = get_string_from_complex_procedure_2();
if (!a.equals(b))
{
    put_up_error_dialog("["+a+"] != ["+b+"]");
}