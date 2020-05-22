<div data-sly-use.slide="${'SliderLogic' @ childNode='slides'}">

    <ul data-sly-list.child="${slide.getChildProperties}">
        <li style="color: #4bff2a">bannerImageName : ${child.bannerImageName || 'no title'} </li>
        <li style="color: #ff3f10">bannerImageRef : ${child.bannerImageRef || 'no title'} </li>
        <li style="color: #ff3f10">img: <img src="${child.bannerImageRef}" width="100"> </li>
        <li style="color: #ebbcff">show : ${child.show || 'no title'} </li>
        <li style="color: #c7a6ff">slideText : ${child.slideText || 'no title'} </li>
        <li style="color: #ff19c2">slideTitle : ${child.slideTitle || 'no title'} </li>
        <li style="color: #6657ff">textPosition : ${child.textPosition || 'no title'} </li>
    </ul>
</div>