function k=doPlot(hp,pos,t1,k)

k=k+1;
if k<length(pos)
   set(hp,'XData',pos(k,1),'YData',pos(k,2),'ZData',pos(k,3));
   axis([0 10 0 10 0 10]);
else
    stop(t1)
end