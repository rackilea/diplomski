package structs.playing;

import structs.playing.Program.Test.Top;
import jnr.ffi.LibraryLoader;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public final class Program {

    public static interface Test {

        void lets_go(Top top);

        public static final class Second extends Struct {

            public final Signed32 a_number = new Signed32();

            public Second(final Runtime runtime) {
                super(runtime);
            }           
        }

        public static final class Top extends Struct {

            private final Pointer secondPointer = new Pointer();            
            public final Second second;

            public Top(final Runtime runtime) {
                super(runtime);                             
                second = new Second(runtime); 
                second.useMemory(secondPointer.getMemory());
            }           
        }
    }

    public static void main(final String[] args) {

         Test test = LibraryLoader.create(Test.class).load("test");
         Runtime runtime = Runtime.getRuntime(test);         
         Top top = new Top(runtime);
         top.second.a_number.set(8);         
         test.lets_go(top);
    }
}