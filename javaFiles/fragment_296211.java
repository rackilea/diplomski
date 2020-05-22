%module Rec
%include "various.i"

%apply char **STRING_ARRAY { char **db }

%include "sab1.hpp"