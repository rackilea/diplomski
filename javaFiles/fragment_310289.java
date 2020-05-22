letters = wm{1};
clr = [0 1 0; 0 0 1; 1 0.8 0;1 0 0]; % corresponding colors
for t = 1:numel(letters)
    hf = figure('position',[200 200 100 110],'color','w');
    ha = axes('parent',hf, 'visible','off','position',[0 0 1 1]);
    ht = text(50,55,letters(t),'color',clr(t,:),'units','pixels',...
        'fontsize',100,'fontweight','norm',...
        'vertical','mid','horizontal','center');
    F = getframe(hf); % rasterize the letter
    img = F.cdata;
    m = any(img < 255,3); % convert to binary image
    m(any(m,2),any(m,1))=1; % mask to cut white borders
    imwrite(reshape(img(repmat(m,[1 1 3])),[sum(any(m,2)) sum(any(m,1)) 3]),...
        [letters(t) '.png'])
    close(hf)
end