// Get foo.g
jclass cls_struct2 = env->FindClass("struct2");
jfieldID fld_struct2_g = env->GetFieldID(cls_struct2, "g", "[Lstruct2;");
jarray foo_g = (jarray) env->GetObjectField(foo, fld_struct2_g);

// Look up field IDs of struct1
jclass cls_struct1 = env->FindClass("struct1");
jfieldID fld_struct1_a = env->GetFieldID(cls_struct1, "a", "C");
jfieldID fld_struct1_d = env->GetFieldID(cls_struct1, "d", "[C");

// Loop over the array
jsize s = env->GetArrayLength(foo_g);
for (int i = 0; i < s; i++) {
  jobject element = env->GetObjectArrayElement(foo_g, i);
  env->SetCharField(element, fld_struct1_a, _struct2[i].a);
  jcharArray element_d = (jcharArray) env->GetObjectField(element, fld_struct1_d);
  env->SetCharArrayRegion(element_d, 0, sizeof(_struct2[i].d) / sizeof(_struct2[i].d[0]), _struct2[i].d);
}