template <class T, class Predicate>
bool testIf(T t, Predicate predicate)
{
    return predicate(t);
}

testIf(s, [](string const & s){return s.length() == 0;});