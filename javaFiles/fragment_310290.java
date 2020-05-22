xlabels = cellstr(num2str(find(high_bit_cols)'));
letters = wm{1};
wmat=wm{2}; % weight matrix from seqlogo
[nletters  npos] = size(wmat);
wmat(wmat<0) = 0; % cut negative values

% prepare the figure
clf
hAx = axes('parent',gcf,'visible','on');
set(hAx,'XLim',[0.5 npos+0.5],'XTick',1:npos,'XTickLabel',xlabels)
ymax = ceil(max(sum(wmat)));
ylim([0 ymax])
axpos = get(hAx,'Position');
step = axpos(3)/npos;

% place images of letters
for i=1:npos
    [wms idx] = sort(wmat(:,i)); % largest on the top
    let_show = letters(idx);
    ybot = axpos(2);
    for s=1:nletters
        if wms(s)==0, continue, end;
        axes('position',[axpos(1) ybot step wms(s)/ymax*axpos(4)])
        ybot = ybot + wms(s)/ymax*axpos(4);
        img = imread([let_show(s) '.png']);
        image(img)
        set(gca,'visible','off')
    end
    axpos(1)=axpos(1)+step;
end