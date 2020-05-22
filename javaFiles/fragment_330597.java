clear all
clc

pos=rand(100,3)*10;  %position matrix of random x,y,z coordinates. 100 time instances here

ax=axes;
set(ax,'NextPlot','replacechildren');
axis([0 10 0 10 0 10]); %set axis limits- fit to your needs

Dt=0.1; %sampling period in secs

k=1;
hp=plot3(pos(k,1),pos(k,2),pos(k,3),'o'); %get handle to dot object

t1=timer('TimerFcn','k=doPlot(hp,pos,t1,k)','Period', Dt,'ExecutionMode','fixedRate');
start(t1);