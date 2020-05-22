// Is this field a constant?
//
// Clarification: A field is considered constant if:
//   1. The field is both static and final
//   2. The field is not one of the special static/final
//      non-constant fields.  These are java.lang.System.in
//      and java.lang.System.out.  Abomination.
//
// A field is also considered constant if
// - it is marked @Stable and is non-null (or non-zero, if a primitive) or
// - it is trusted or
// - it is the target field of a CallSite object.
//
// See ciField::initialize_from() for more details.
//
// A user should also check the field value (constant_value().is_valid()), since
// constant fields of non-initialized classes don't have values yet.
bool is_constant() const { return _is_constant; }