%module(directors="1") modulename
%{
   #include "binded.h"
%}
%feature("director") callback;
%include "binded.h"