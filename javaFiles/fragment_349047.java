struct input_event {
      struct timeval time;
      __u16 type;
      __u16 code;
      __s32 value;
};