// catch then rethrow
void foo() throws E
{
    try {
        peek();
    } catch (E e) {
        // something, then
        throw e;
    }
}