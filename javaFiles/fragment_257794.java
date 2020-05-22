public class MIDIEvent {
    int delta_time;
    int channel;
    int event_type;    //Use of enum or final variables is interesting

    //two bytes, interpret according the message type
    byte byte0;
    byte byte1;

    //or more memory consuming
    byte key;
    byte pressure;
    byte controller;
    short bend;
}